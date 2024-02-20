const usernameInput = document.getElementById("usernameInput");
const passwordInput = document.getElementById("passwordInput");
const loginBtn = document.getElementById("loginBtn");
const showPetsBtn = document.getElementById("showPetsBtn");
const petTableBody = document.getElementById("petTable");

loginBtn.onclick = loginFunc;
showPetsBtn.onclick = getPets;

const API_URL ='http://localhost:8080/UserMgmtServlet/app'

async function getPets(){
    let response = await 
        fetch(API_URL+"/pets",
        {
            method:"GET",
            credentials:'include'
        });

    if(response.status===200){
        let data = await response.json();
        showPets(data);
    }else{
        console.log("request failed. Status code:"+response.status);
    }
}

async function loginFunc(){
    let user = {username:usernameInput.value, 
        password:passwordInput.value}

    let json = JSON.stringify(user);

    let response = await fetch(API_URL,{
            method:'POST',
            body:json,
            credentials:'include'//ensures browser handles cookies properly
        })
    
    if(response.status===200){
        let loginDiv = document.getElementById("loginDiv");
        loginDiv.innerHTML = "";
        loginDiv.innerText = "login successful!"
    }else{
        let para = document.createElement("p");
        para.style = "color:red";
        para.innerText = "LOGIN FAILED!!!!";
        document.getElementById("loginDiv").appendChild(para);
    }
}

function showPets(data){
    petTableBody.innerHTML="";

    for(let pet of  data){
        let row = document.createElement("tr");
        let id = document.createElement("td");
        id.innerText = pet.idNumber;
        row.appendChild(id);
        let type = document.createElement("td");
        type.innerText = pet.species;
        row.appendChild(type);
        let desc = document.createElement("td");
        desc.innerText = pet.description;
        row.appendChild(desc);
        let price = document.createElement("td");
        price.innerText = "$"+pet.price;
        row.appendChild(price);
        petTableBody.appendChild(row);
    }
}