import React, {Component} from 'react';
import JobHandel from "./JobHandel";

export default class App extends Component {
    render() {
        return (
            <div>
                <div style={{
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'center'}}>
                    <JobHandel/>
                </div>
            </div>
        )
    }
}
