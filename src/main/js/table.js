import React from "react";
import ReactTable from "react-table";
import "react-table/react-table.css";
import data from "./data";

const columns = [
    {
        Header: "Город",
        accessor: "city" // String-based value accessors!
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

const TableComponent = () => {
    return (
        <div>
            <ReactTable
                data={data}
                columns={columns}
                defaultPageSize={6}
                minRows={3}
            />
        </div>
    );
};

export default TableComponent;
