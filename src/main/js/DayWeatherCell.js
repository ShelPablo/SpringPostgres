import React from "react";

function DayWeatherCell(props) {
  return (
    <div>
      <p>{props.date}</p>
      <p>
        t: {props.tmin} - {props.tmax} &deg;C
      </p>
      <p>
        ветер: {props.windSpeedMin} - {props.windSpeedMax} м/с
      </p>
    </div>
  );
}

export default DayWeatherCell;
