<template>
    <div class = "demo" >
        <h1 class="title">Comdolidol-i CodeEditor</h1>
        <div class="container">
            <div class = "subtitle">
            <p>
                front-end used <span style = "color : red; font-weight: bold;">vue.js</span> and back-end used <span style = "color : red; font-weight: bold;">the Spring Boot framework</span>.
                The screen was conceived by importing <span style = "color : red; font-weight: bold;">"simple-code-editor"</span> as a code editor, and when you write a python code in the code editor, the result value is converted into a string and delivered to the server.
                The server saves the received string value as a python file, executes the saved python file using the <span style = "color : red; font-weight: bold;">"PythonInterpreter" </span>library, and passes the output value back to the client.
            </p>
            </div>
            <p>Code Editor</p>
            <div class = "editor">
                <CodeEditor v-model="c1" width= "600px" height="500px"  :language_selector="false" :languages="[['python', 'PYTHON']]"></CodeEditor>
            </div>
            <div class = "buttonArea">
                <button class="b1" @click="resultBtn()">compile</button>
            </div>
            <p>Result</p>
            <div class = "editor">
                <CodeEditor v-model="c2" width= "600px" height="100px" :read_only="true" :hide_header="true" :language_selector="false"></CodeEditor>
            </div>
        </div>
    </div>
</template> 
<script>
import CodeEditor from 'simple-code-editor';
import axios from 'axios';
export default {  
    components : {
        CodeEditor
    },
    data(){
        return {
            c1: '# please start code',
            c2: 'waiting complie code..',
        }
    },
    methods : {
        resultBtn(){
            axios.get('http://localhost:8080/api',{
                params :{
                    code : encodeURI(this.c1)
                    }
                }).then((response)=>{
                    console.log(response.data);
                    this.c2 =  response.data;
                }).catch((error)=>{
                    console.log("failed post http://localhost:8080/");
                    console.log(error);
                })
            }
        }

}
</script>
 <style scoped>
.b1{
    color: #00c55a;
    background: #005b2a;
    border-radius: 6px;
    cursor: pointer;
    border: none;
    padding: 8px 12px;
    font-size: 14px;
    margin-left: 500px;
}
.buttonArea{
    margin-top: 20px;
    display: flex;
    justify-content: space-between;
}
.editor {
    margin-top: 32px;
    display: flex;
    flex-direction: column;
    font-size: 0;
    position: relative;
    text-align: left;
}
div {
    display: block;
}
.container {
    margin: 0 auto;
    max-width: 580px;
}
.demo {
    background: #1a1d1c;
    box-sizing: border-box;
    padding: 60px 20px 120px 20px;
    margin: 0 auto;
    height: 1250px;
}

h1, h2 {
    color : #e4e8e7;
}
mark {
    color : green;
}
h1 {
    margin: 50px 0;
    font-size: 46px;
    text-align: center;
}
h1, h2, h3, h4 {
    font-family: Quicksand;
}
h1 {
    display: block;
    font-size: 2em;
    margin-block-start: 0.67em;
    margin-block-end: 0.67em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
}
.title{
    font-size : 60px;
}
.subtitle {
    text-align: center;
}
p {
    color: #e4e8e7;
    line-height: 1.5;
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}

</style>
