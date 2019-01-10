import React from "react";
import ReactTable from "react-table";
import "react-table/react-table.css";

const handleClick = () => {
    console.log("Click");
};

const TableComponent = props => {
    const columns = [
        {
            Cell: row => {
                return (
                    <div>
                        <button onClick={(e) => props.onCityClick(props.data[row.index].city)}>
                            {props.data[row.index].city}
                        </button>
                    </div>
                );
            }
        },
        {
            Header: "Температура",
            accessor: "temp"
        },
        {
            Header: "Направление ветра",
            accessor: "windDir"
        },
        {
            Header: "Облачность",
            accessor: "cloudness"
        }

    ];

    return (
        <div>
            <ReactTable
                data={props.data}
                columns={columns}
                defaultPageSize={6}
                minRows={3}
            />
        </div>
    );
};

export default TableComponent;
