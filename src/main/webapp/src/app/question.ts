import { Examination } from "./examination";

export class Question {
    id: Number;
    questionName: string;
    examination:Examination;
    constructor(examination:Examination, questionName: string){
        this.examination=examination; 
        this.questionName = questionName;
    }
}
