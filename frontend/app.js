const atividades = document.querySelector(".listaAtividades");

const inputName = document.querySelector(".inputName");
const inputDescription = document.querySelector(".inputDescription");
const inputDeadline = document.querySelector(".inputDeadline");
const inputPriority = document.querySelector(".inputPriority");
const inputCategory = document.querySelector(".inputCategory");
const inputStatus = document.querySelector(".inputStatus");

const erro = document.querySelector(".erro");

function criaTask(){
    const task = document.createElement("div");
    task.classList.add("task");
    const taskname = document.createElement("p");
    taskname.textContent = inputName.value
    const taskdescription = document.createElement("p");
    taskdescription.textContent = inputDescription.value;
    const taskdeadline = document.createElement("p");
    taskdeadline.textContent = inputDeadline.value;
    const taskpriority = document.createElement("p");
    taskpriority.textContent = inputPriority.value;
    const taskcategory = document.createElement("p");
    taskcategory.textContent = inputCategory.value;
    const taskstatus = document.createElement("p");
    taskstatus.textContent = inputStatus.value;

    const botaoExcluir = document.createElement("button");
    botaoExcluir.textContent = "Excluir";
    botaoExcluir.classList.add("botaoExcluir");
    botaoExcluir.addEventListener("click", () => removeTask(task));

    const botaoEditar = document.createElement("button");
    botaoEditar.textContent = "Editar";
    botaoEditar.classList.add("botaoEditar");
    botaoEditar.addEventListener("click", () => editaTask(task));

    task.appendChild(taskname);
    task.appendChild(taskdescription);
    task.appendChild(taskdeadline);
    task.appendChild(taskpriority);
    task.appendChild(taskcategory);
    task.appendChild(taskstatus);
    task.appendChild(botaoEditar);
    task.appendChild(botaoExcluir);

    atividades.appendChild(task);
};

function cadastraTask(){
    if(inputPriority.value>0 && inputPriority.value<6){
        erro.style.display = "none";
        criaTask()
    }else{
        erro.style.display = "grid";
        erro.innerHTML = "A task inserida não é válida!"
    }
    limpaBuffer();
}

function removeTask(task){
    atividades.removeChild(task);
}

function editaTask(task){
    removeTask(task);
    criaTask();
    limpaBuffer();
};

function limpaBuffer(){
    inputName.value="";
    inputStatus.value="";
    inputPriority.value="";
    inputCategory.value="";
    inputDeadline.value="";
    inputDescription.value="";
}

window.addEventListener("keypress", (e) =>{
    if(e.key === "Enter"){
        cadastraTask();
    }
});