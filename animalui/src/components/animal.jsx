import axios from "axios";
import { useEffect, useState } from "react";

function Animal() {
  // The Logic of the User Interface
  const [animalid, setId] = useState('');
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
        animalid:animalid,
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
        animalid:animalid,
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
    <div>
      <h1>Animal Information</h1>
      <div class="container mt-4">
        <form>

        <div class="form-group">
            <label>Animal ID</label>
            <input
              type="text"
              class="form-control"
              id="animalid"
              value={animalid}
              onChange={(event) => {
                setId(event.target.value);
              }}
            />
          </div>

          <div class="form-group">
            <label>Animal Name</label>
            <input
              type="text"
              class="form-control"
              id="animalname"
              value={animalname}
              onChange={(event) => {
                setName(event.target.value);
              }}
            />
          </div>

          <div class="form-group">
            <label>Animal Address</label>
            <input
              type="text"
              class="form-control"
              id="animaladdress"
              value={animaladdress}
              onChange={(event) => {
                setAddress(event.target.value);
              }}
            />
          </div>

          <div class="form-group">
            <label>Phonenumber</label>
            <input
              type="text"
              class="form-control"
              id="phonenumber"
              value={phonenumber}
              onChange={(event) => {
                setPhonenumber(event.target.value);
              }}
            />
          </div>
          <div>
            <button class="btn btn-primary mt-4" onClick={save}>
              Register
            </button>
            <button class="btn btn-warning mt-4" onClick={update}>
              Update
            </button>
          </div>
        </form>
      </div>
      <br />
      <table class="table table-grey" align="center">
        <thead>
          <tr>
            <th scope="col">Animal ID</th>
            <th scope="col">Animal Name</th>
            <th scope="col">Animal Address</th>
            <th scope="col">Phonenumber</th>
            <th scope="col">Option</th>
          </tr>
        </thead>
        {animals.map(function fn(animal) {
          return (
            <tbody>
              <tr>
                <td>{animal.animalid}</td>
                <td>{animal.animalname}</td>
                <td>{animal.animaladdress}</td>
                <td>{animal.phonenumber}</td>
                <td>
                  <button
                    type="button"
                    class="btn btn-warning"
                    onClick={() => editAnimal(animal)}
                  >
                    Edit
                  </button>
                  <button
                    type="button"
                    class="btn btn-danger"
                    onClick={() => DeleteAnimal(animal.animalid)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            </tbody>
          );
        })}
      </table>
    </div>
  );
}
export default Animal;
