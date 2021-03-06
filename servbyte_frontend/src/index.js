import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Landing from './components/LandingPage'
import reportWebVitals from './reportWebVitals';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import RestaurantResultPage from "./components/RestaurantResultPage";
import AllRestaurantPage from "./components/AllRestaurantpage";
import Nav from "./components/Nav";
import SingleRestaurantPage from "./components/SingleRestaurantPage";
import SingleMealPage from "./components/SingleMealPage";
import PaymentPage from "./components/PaymentPage";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
      <Router>
          <Nav />
          <Routes>
              <Route path="/" element={<Landing />} />
              <Route path="/restaurants" element={<AllRestaurantPage/>}/>
              <Route path="/search" element={<RestaurantResultPage />} />
              <Route path="/single/:id" element={<SingleRestaurantPage/>}/>
              <Route path="/singleMealPage/:id" element={<SingleMealPage/>}/>
              <Route path="/paymentPage/:amount" element={<PaymentPage/>}/>
          </Routes>
      </Router>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
