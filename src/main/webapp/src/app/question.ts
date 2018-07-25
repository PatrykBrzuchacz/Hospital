import { Examination } from "./examination";

export class Question {
    id: Number;
     name: string;
    examination:Examination;
    constructor(examination:Examination, name: string){
        this.examination=examination; 
        this.name = name;
    }
}
