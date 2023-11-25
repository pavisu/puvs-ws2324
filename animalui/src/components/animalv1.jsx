import axios from "axios";
import { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Animal.css"; // Import custom styles
// 1. import `ChakraProvider` component
import {
  ChakraProvider,
  WrapItem,
  Button,
  Wrap,
  Center,
} from "@chakra-ui/react";
import { AddIcon, DeleteIcon, EditIcon, RepeatIcon } from "@chakra-ui/icons";

function Animal() {
  // The Logic of the User Interface
  const [animalid, setId] = useState("");
  const [animalname, setName] = useState("");
  const [animaladdress, setAddress] = useState("");
  const [phonenumber, setPhonenumber] = useState("");
  const [animals, setAnimals] = useState([]);

  const baseUrl = "https://8081-pavisu-puvsws2324-vzjldk87m76.ws-eu106.gitpod.io/api/v1/animals/" //here you have to change the URL of the springAPI

  useEffect(() => {
    (async () => await Load())();
  }, []);

  async function Load() {
    try {
      const result = await axios.get(baseUrl);
      console.log(result.data); // Log the response data
      setAnimals(result.data);
    } catch (error) {
      console.error("Error loading data:", error);
    }
  }

  async function save(event) {
    event.preventDefault();
    try {
      await axios.post(baseUrl, {
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
      baseUrl + animalid
    );
    alert("Animal deleted!");
    Load();
  }

  async function update(event) {
    event.preventDefault();

    try {
      await axios.put(baseUrl + animalid, {
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
              <Center>
                <Wrap spacing={4}>
                  <WrapItem>
                    <Button
                      rightIcon={<AddIcon />}
                      colorScheme="pink"
                      onClick={save}
                    >
                      Register
                    </Button>
                  </WrapItem>
                  <WrapItem>
                    <Button
                      rightIcon={<RepeatIcon />}
                      colorScheme="yellow"
                      onClick={update}
                    >
                      Update
                    </Button>
                  </WrapItem>
                </Wrap>
              </Center>
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
                {animals.map((animal) =>{
                  return (
                    <tr key={animal.animalid}>
                      {/*<td>{animal.animalid}</td>*/}
                      <td>{animal.animalname}</td>
                      <td>{animal.animaladdress}</td>
                      <td>{animal.phonenumber}</td>
                      <td>
                        <Center>
                          {/* Buttons for editing and deleting animals */}
                          <Wrap spacing={4}>
                            <WrapItem>
                              <Button
                                rightIcon={<EditIcon />}
                                colorScheme="purple"
                                onClick={() => editAnimal(animal)}
                              >
                                Edit
                              </Button>
                            </WrapItem>
                            <WrapItem>
                              <Button
                                rightIcon={<DeleteIcon />}
                                colorScheme="red"
                                onClick={() => DeleteAnimal(animal.animalid)}
                              >
                                Delete
                              </Button>
                            </WrapItem>
                          </Wrap>
                        </Center>
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
