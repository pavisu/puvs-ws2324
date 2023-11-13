import axios from "axios";
import { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Animal.css"; // Import custom styles
// 1. import `ChakraProvider` component
import { ChakraProvider } from "@chakra-ui/react";

function Animal() {
  // The Logic of the User Interface
  const [animalid, setId] = useState("");
  const [animalname, setName] = useState("");
  const [animaladdress, setAddress] = useState("");
  const [phonenumber, setPhonenumber] = useState("");
  const [animals, setAnimals] = useState([]);

  useEffect(() => {
    (async () => await Load())();
  }, []);

  async function Load() {
    const result = await axios.get(
      "http://localhost:8081/api/v1/animal/allanimals"
    );
    setAnimals(result.data);
    console.log(result.data);
  }

  async function save(event) {
    event.preventDefault();
    try {
      await axios.post("http://localhost:8081/api/v1/animal/save", {
        //animalid: animalid,
        animalname: animalname,
        animaladdress: animaladdress,
        phonenumber: phonenumber,
      });
      alert("Animal registered!");
      setId("");
      setName("");
      setAddress("");
      setPhonenumber("");
      Load();
    } catch (err) {
      alert("Registration failed!");
    }
  }

  async function editAnimal(animals) {
    setId(animals.animalid);
    setName(animals.animalname);
    setAddress(animals.animaladdress);
    setPhonenumber(animals.phonenumber);
  }

  async function DeleteAnimal(animalid) {
    await axios.delete(
      "http://localhost:8081/api/v1/animal/delete/" + animalid
    );
    alert("Animal deleted!");
    Load();
  }

  async function update(event) {
    event.preventDefault();

    try {
      await axios.put("http://localhost:8081/api/v1/animal/edit/" + animalid, {
        //animalid: animalid,
        animalname: animalname,
        animaladdress: animaladdress,
        phonenumber: phonenumber,
      });
      alert("Animal updated!");
      setId("");
      setName("");
      setAddress("");
      setPhonenumber("");
      Load("");
    } catch (err) {
      alert("Update failed!");
    }
  }

  // The User Interface
  return (
    <ChakraProvider>
      <div className="container mt-5 cute-ui">
        <h1 className="text-center mb-4">Animal Information</h1>
        <div className="row">
          <div className="col-md-4">
            {/* Form input fields for animal data */}
            <form>
              <div className="form-group">
                <label>Animal Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="animalname"
                  value={animalname}
                  onChange={(event) => {
                    setName(event.target.value);
                  }}
                />
              </div>
              <div className="form-group">
                <label>Animal Address</label>
                <input
                  type="text"
                  className="form-control"
                  id="animaladdress"
                  value={animaladdress}
                  onChange={(event) => {
                    setAddress(event.target.value);
                  }}
                />
              </div>
              <div className="form-group">
                <label>Phonenumber</label>
                <input
                  type="text"
                  className="form-control"
                  id="phonenumber"
                  value={phonenumber}
                  onChange={(event) => {
                    setPhonenumber(event.target.value);
                  }}
                />
              </div>
              <div className="text-center">
                <button
                  className="btn btn-primary mt-3 cute-button"
                  onClick={save}
                >
                  Register
                </button>
                <button
                  className="btn btn-secondary mt-3 ml-2 cute-button-update"
                  onClick={update}
                >
                  Update
                </button>
              </div>
            </form>
          </div>
          <div className="col-md-8">
            <table className="table table-striped cute-table">
              <thead>
                <tr>
                  {/*<th scope="col">Animal ID</th>*/}
                  <th scope="col">Animal Name</th>
                  <th scope="col">Animal Address</th>
                  <th scope="col">Phonenumber</th>
                  <th scope="col">Option</th>
                </tr>
              </thead>
              <tbody>
                {animals.map(function fn(animal) {
                  return (
                    <tr key={animal.animalid}>
                      {/*<td>{animal.animalid}</td>*/}
                      <td>{animal.animalname}</td>
                      <td>{animal.animaladdress}</td>
                      <td>{animal.phonenumber}</td>
                      <td>
                        {/* Buttons for editing and deleting animals */}
                        <button
                          type="button"
                          className="btn btn-warning cute-button"
                          onClick={() => editAnimal(animal)}
                        >
                          Edit
                        </button>
                        <button
                          type="button"
                          className="btn btn-danger cute-button-two"
                          onClick={() => DeleteAnimal(animal.animalid)}
                        >
                          Delete
                        </button>
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </ChakraProvider>
  );
}
export default Animal;
