import axios from "axios";
import { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import './Animal.css'; // Import custom styles


function Animal() {

// Logic of the UI 
    
  // State variables for managing form input and data
  const [animalData, setAnimalData] = useState({
    animalid: "",
    animalname: "",
    animaladdress: "",
    phonenumber: "",
  });

  const [animals, setAnimals] = useState([]);
  const [editingAnimalId, setEditingAnimalId] = useState(null);

  useEffect(() => {
    LoadAnimals();
  }, []);

  async function LoadAnimals() {
    try {
    // Fetch the list of animals from the API and update the state.
      const response = await axios.get(
        "http://localhost:8081/api/v1/animal/allanimals"
      );
      setAnimals(response.data);
    } catch (error) {
    // Handle and log errors if the API request fails.
      console.error("Error loading animals:", error);
    }
  }

  async function saveAnimal() {
    try {
    // Send a POST request to register a new animal using the form data.
      await axios.post("http://localhost:8081/api/v1/animal/save", animalData);
      alert("Animal registered!");
      clearForm();
      LoadAnimals();
    } catch (error) {
      alert("Registration failed!");
      console.error("Error saving animal:", error);
    }
  }

  

  async function updateAnimal() {
    try {
    // Send a PUT request to update an existing animal using the form data and the ID of the animal to update.
      await axios.put(
        `http://localhost:8081/api/v1/animal/edit/${editingAnimalId}`,
        animalData
      );
      alert("Animal updated!");
      clearForm();
      LoadAnimals();
    } catch (error) {
      alert("Update failed!");
      console.error("Error updating animal:", error);
    }
  }

  async function deleteAnimal(animalId) {
    try {
    // Send a DELETE request to delete an animal by its ID.
      await axios.delete(
        `http://localhost:8081/api/v1/animal/delete/${animalId}`
      );
      alert("Animal deleted!");
      LoadAnimals();
    } catch (error) {
      alert("Deletion failed!");
      console.error("Error deleting animal:", error);
    }
  }

  async function editAnimal(animals) {
    // Set the state with the data of the selected animal for editing
    setAnimalData({
      animalid: animals.animalid,
      animalname: animals.animalname,
      animaladdress: animals.animaladdress,
      phonenumber: animals.phonenumber,
    });
    setEditingAnimalId(animals.animalid); // Set the editingAnimalId state
  }

  function clearForm() {
    // Clear the form fields and reset the editing state.
    setAnimalData({
      animalid: "",
      animalname: "",
      animaladdress: "",
      phonenumber: "",
    });
    setEditingAnimalId(null);
  }


  //User Interface
  return (
      
      <div className="container mt-5 cute-ui">
      <h1 className="text-center mb-4">Animal Information</h1>
        
          <div className="row">
          <div className="col-md-4">
            {/* Form input fields for animal data */}
        <form>
            <div className="form-group">
            <label>Animal ID</label>
            <input
              type="text"
              className="form-control"
              value={animalData.animalid}
              onChange={(e) =>
                setAnimalData({ ...animalData, animalid: e.target.value })
              }
            />
          </div>
          <div className="form-group">
            <label>Animal Name</label>
            <input
              type="text"
              className="form-control"
              value={animalData.animalname}
              onChange={(e) =>
                setAnimalData({ ...animalData, animalname: e.target.value })
              }
            />
          </div>
          <div className="form-group">
            <label>Animal Address</label>
            <input
              type="text"
              className="form-control"
              value={animalData.animaladdress}
              onChange={(e) =>
                setAnimalData({ ...animalData, animaladdress: e.target.value })
              }
            />
          </div>
          <div className="form-group">
            <label>Phonenumber</label>
            <input
              type="text"
              className="form-control"
              value={animalData.phonenumber}
              onChange={(e) =>
                setAnimalData({ ...animalData, phonenumber: e.target.value })
              }
            />
          </div>
          <div className="text-center">
            {/* Unified button to handle registration and update */}
            <button
                className={`btn ${editingAnimalId ? "btn-warning" : "btn-primary"} mt-3`}
                onClick={editingAnimalId ? updateAnimal : saveAnimal}
            >
              {editingAnimalId ? "Update" : "Register"}
            </button>
            <button className="btn btn-secondary mt-3 ml-2 cute-button" onClick={clearForm}>
              Clear
            </button>
          </div>
        </form>
      </div>
      <div className="col-md-8">
          <table className="table table-striped cute-table">
        <thead>
          <tr>
            <th scope="col">Animal ID</th>
            <th scope="col">Animal Name</th>
            <th scope="col">Animal Address</th>
            <th scope="col">Phonenumber</th>
            <th scope="col">Options</th>
          </tr>
        </thead>
        <tbody>
          {animals.map((animal) => (
            <tr key={animal.animalid}>
              <td>{animal.animalid}</td>
              <td>{animal.animalname}</td>
              <td>{animal.animaladdress}</td>
              <td>{animal.phonenumber}</td>
              <td>
                {/* Buttons for editing and deleting animals */}
                <button
                  className="btn btn-warning cute-button"
                  onClick={() => editAnimal(animal)}
                >
                  Edit
                </button>
                <button
                  className="btn btn-danger cute-button"
                  onClick={() => deleteAnimal(animal.animalid)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
    </div>
    </div>
  );
}

export default Animal;
