import { ExaminationTypes } from './examination-types.enum';
import  { Question } from './question';
export class Examination {
    id: number;
    name: String;
    type: ExaminationTypes;
    questions:Question[];
    constructor(name:String, type:ExaminationTypes){
        this.name=name;
        this.type=type;
        this.questions=[];
    }
}
