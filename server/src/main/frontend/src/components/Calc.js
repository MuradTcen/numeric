import React, {Component} from "react";
import axios from 'axios';

export class Calc extends Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
    }

    initialState = {
        sum: 0,
    };

    componentDidMount() {
        this.getSum();
    }

    getSum = () => {
        axios.get("http://localhost:8080/api/calc")
            .then(response => {
                if (response.data != null) {
                    this.setState({
                        sum: response.data,
                    })
                    console.log(response);
                }
            }).catch((error) => {
            console.error("Error - " + error)
        });
    };


    render() {
        const {sum} = this.state;

        return (
            <div>
                Sum: {sum}
            </div>
        );
    }
}
