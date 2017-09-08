var url = "api/quote/random";
var con = {method: "get"};
var prom = fetch(url, con);

prom.then(function (response) {
    return response.json();
}).then(function (json) {
    document.querySelector("#random").innerHTML = json.quote;
});

var button = document.querySelector("#quoteForm submit[name='newQuote']");

button.onclick = prom.then(function (response) {
    return response.json();
}).then(function (json) {
    document.querySelector("#random").innerHTML = json.quote;
});
