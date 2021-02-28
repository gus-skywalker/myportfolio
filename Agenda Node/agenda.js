var contatos = [
  document.querySelector("#campo-nome"),
  document.querySelector("#campo-endereco"),
  document.querySelector("#campo-bairro"),
  document.querySelector("#campo-telefoneFixo"),
  document.querySelector("#campo-celular"),
];
//console.log(contatos);

document.querySelector('#formulario').addEventListener("submit", function(event){

  event.preventDefault();

  var tr = document.createElement('tr');

  /*campo é o meu elemento, como se fosse o i.*/
  contatos.forEach(function(posicao) {
    td = document.createElement('td');
    td.textContent = posicao.value;
    tr.appendChild(td);
  });

  var tabela = document.querySelector("table tbody");

  tabela.appendChild(tr);

  for(var i=0;i <=contatos.length;i++){
    this[i].value ='';
  }

  contatos[0].focus();
});
