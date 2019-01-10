import React from "react";
import { render } from "react-dom";

//import styles from "./style.css";
import TableComponent from "./allCitiesWeather";
import OneCityTable from "./oneCityWeather";
import $ from "jquery";

const app = document.getElementById("app");

function ShowAllCitiesWeather() {

    $.ajax({
        type: 'GET',
        dataType: "json",
        url: '/allCities',
        success: function(data) {
            console.log(data);
            render(<TableComponent data={data} onCityClick={ShowOneCityWeather} />, app);
        }
    });
}
function ShowOneCityWeather(city) {
    $.ajax({
      type: "GET",
      url: "/oneCity/" + city,
      success: function(data) {
          render(<OneCityTable  data={data}  onBackCallback={ShowAllCitiesWeather}/>, app);
      }
    });
}

ShowAllCitiesWeather();
