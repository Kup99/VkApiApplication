import React, {Component} from 'react';
import {TextField} from '@material-ui/core';
import Button from '@material-ui/core/Button';
import axios from "axios";

export default class JobHandel extends Component {

    sendAddress = (address) => {
        this.setState({
            address: ''
        })

        const url = `http://localhost:8080/rest/api/view/?address=`+this.state.address
        axios({
            method: 'GET',
            url: url
        })
            .then(address) // this function would make your data pretty so you can just put it in state
            .then(data => {
                // this.setState({
                //     haveData: true,
                //     fetching: false,
                //     data
                // })
                console.log(data)
            })
            .catch(err => console.warn('Error:', err));
    }

    handleTextFieldChange = (e) => {
    this.setState({
           address: e.target.value
        });
    }

    render() {
        return (
            <div>
                <div>
                    <h3>Определитель профессии</h3>
                    <form>
                        <h3>Введите url страницы человека</h3>
                        <TextField onChange={this.handleTextFieldChange} id="outlined-basic" label="vk.com" variant="outlined"/>
                    </form>
                </div>
                <br></br>
                <div>
                    <Button onClick={this.sendAddress} variant="contained">Отправить</Button>
                </div>
            </div>
        );
    }
}
