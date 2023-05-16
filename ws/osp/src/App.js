import "./App.css";
import Navbar from "./components/Navbar";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import About from "./pages/About";
import CreateSurvey from "./pages/CreateSurvey";
import EditSurvey from "./pages/EditSurvey";
import RespondToSurvey from "./pages/RespondToSurvey";

const routes = [
  { path: "/", name: "Home", Component: Home },
  { path: "/about", name: "About", Component: About },
  { path: "/createSurvey", name: "CreateSurvey", Component: CreateSurvey },
  {
    path: "/respondToSurvey",
    name: "ResponToSurvey",
    Component: RespondToSurvey,
  },
  {
    path: "/editSurvey",
    name: "EditSurvey",
    Component: EditSurvey,
  },
];

function App() {
  return (
    <div className="App">
      <div className="app-body">
        <Navbar />
        <br />
        <div className="pages-container">
          <Routes>
            {routes.map(({ path, Component }) => (
              <Route key="name" path={path} element={<Component />}></Route>
            ))}
          </Routes>
        </div>
      </div>
    </div>
  );
}

export default App;
