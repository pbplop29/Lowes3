import "./App.css";
import Navbar from "./components/Navbar";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import About from "./pages/About";
import CreateSurvey from "./pages/CreateSurvey";

const routes = [
  { path: "/", name: "Home", Component: Home },
  { path: "/about", name: "About", Component: About },
  { path: "/createSurvey", name: "CreateSurvey", Component: CreateSurvey },
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
