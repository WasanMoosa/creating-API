// let id = 1;

// let url = "https://thedynamicdoers.com/api/students";


// const getStudents = () => {
//     reqConfiq ={
//         method: "GET"
//         }

//         fetch(url, reqConfiq)
//         .then((response) => {return response.json();})
//         .then((parsedRResponse) => { console.log(parsedRResponse);})
// }
// getStudents();

const getStudent = (id) => {
    reqConfiq = {
        method: "GET"
    }
    url = `http://localhost:8080/api/students/${id}`

    if (isNaN(id)) {
        url = `http://localhost:8080/api/students`;
    }


    fetch(url, reqConfiq)
        .then((response) => { return response.json(); })
        .then((parsedRResponse) => { console.log(parsedRResponse); })
}

getStudent();



// // function getStudent(){};
// const postStudent = () => {
//     student ={
//         name: "Ms wsn",
//         email: "w@wsn.com"

//     }
//     reqConfiq = {
//         method: 'POST',
//         headers: {
//           'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(student)
//       }
//       fetch(url, reqConfiq)
//       .then((response) => { return response.json(); })
//       .then((parsedRResponse) => { console.log(parsedRResponse); })
// }
// postStudent();

