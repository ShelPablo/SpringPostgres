import React from "react";
import ReactTable from "react-table";
import "react-table/react-table.css";
import DayWeatherCell from "./DayWeatherCell";

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

    var titleStyle = {
        textAlign: 'center',
        fontSize: 16
    };

    return (
    <div>
      <h1 style={titleStyle}>
          Погода в городе {props.city} за 28 дней</h1>
      <BackButton onBackCallback = {props.onBackCallback}/>
      <ReactTable
        data={props.data}
        columns={columns}
        defaultPageSize={6}
        minRows={3}
        showPagination={false}
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
