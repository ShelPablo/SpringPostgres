import React from "react";
import ReactTable from "react-table";
import "react-table/react-table.css";
//import dataOne from "./dataOne";
import DayWeatherCell from "./DayWeatherCell";
//import style from "./style.css";
//console.log(style);

function BackButton(props) {
  return <button onClick={props.onBackCallback}>back</button>;
}
const OneCityTable = props => {
  const columns = [
    {
      Cell: row => (
        <DayWeatherCell
          date={row.original[0].date}
          tmin={row.original[0].tmin}
          tmax={row.original[0].tmax}
          windSpeedMin={row.original[0].windSpeedMin}
          windSpeedMax={row.original[0].windSpeedMax}
        />
      )
    },
    {
      Cell: row => (
        <DayWeatherCell
          date={row.original[1].date}
          tmin={row.original[1].tmin}
          tmax={row.original[1].tmax}
          windSpeedMin={row.original[1].windSpeedMin}
          windSpeedMax={row.original[1].windSpeedMax}
        />
      )
    },
    {
      Cell: row => (
        <DayWeatherCell
          date={row.original[2].date}
          tmin={row.original[2].tmin}
          tmax={row.original[2].tmax}
          windSpeedMin={row.original[2].windSpeedMin}
          windSpeedMax={row.original[2].windSpeedMax}
        />
      )
    },
    {
      Cell: row => (
        <DayWeatherCell
          date={row.original[3].date}
          tmin={row.original[3].tmin}
          tmax={row.original[3].tmax}
          windSpeedMin={row.original[3].windSpeedMin}
          windSpeedMax={row.original[3].windSpeedMax}
        />
      )
    },
    {
      Cell: row => (
        <DayWeatherCell
          date={row.original[4].date}
          tmin={row.original[4].tmin}
          tmax={row.original[4].tmax}
          windSpeedMin={row.original[4].windSpeedMin}
          windSpeedMax={row.original[4].windSpeedMax}
        />
      )
    },
    {
      Cell: row => (
        <DayWeatherCell
          date={row.original[5].date}
          tmin={row.original[5].tmin}
          tmax={row.original[5].tmax}
          windSpeedMin={row.original[5].windSpeedMin}
          windSpeedMax={row.original[5].windSpeedMax}
        />
      )
    },
    {
      Cell: row => (
        <DayWeatherCell
          date={row.original[6].date}
          tmin={row.original[6].tmin}
          tmax={row.original[6].tmax}
          windSpeedMin={row.original[6].windSpeedMin}
          windSpeedMax={row.original[6].windSpeedMax}
        />
      )
    }
  ];

  return (
    <div>
      <BackButton onBackCallback = {props.onBackCallback}/>
      <ReactTable
        data={props.data}
        columns={columns}
        defaultPageSize={6}
        minRows={3}
      />
    </div>
  );
};

// {
//   (state, makeTable, instance) => {
//     return (

//       <div
//         style={{
//           //background: "#ffff00",
//           //overflow: "hidden",
//           padding: "0px"
//         }}
//       >
//         {makeTable()}
//       </div>
//     );
//   }
// }

export default OneCityTable;
