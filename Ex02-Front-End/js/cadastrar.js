function submitForm() {
    // Captura os dados do formulário
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const firstName = document.getElementById('first-name').value;
    const lastName = document.getElementById('last-name').value;
    const cpf = document.getElementById('cpf').value;
    const phone = document.getElementById('phone').value;
    const photo = document.getElementById('photo').files[0]; // A foto é um arquivo

    // Cria um objeto FormData
    const formData = new FormData();
    formData.append('username', username);
    formData.append('password', password);
    formData.append('firstName', firstName);
    formData.append('lastName', lastName);
    formData.append('cpf', cpf);
    formData.append('phone', phone);
    formData.append('photo', photo); // Adiciona a foto ao FormData

    // Faz a requisição POST para o servidor
    fetch('http://localhost:8080/usuario', {
        method: 'POST',
        body: formData, // Envia o FormData com os dados do formulário
    })
    .then(response => response.json()) // Espera uma resposta JSON
    .then(data => {
        if (data.success) {
            alert('Cadastro realizado com sucesso!');
        } else {
            alert('Erro ao cadastrar!');
        }
    })
    .catch(error => {
        console.error('Erro ao fazer a requisição:', error);
        alert('Erro na comunicação com o servidor');
    });
}
