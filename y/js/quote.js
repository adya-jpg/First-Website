
const quotes = [

  "les forêts se souviennent peut-être des gens.",

  "la pluie rend le monde plus silencieux.",

  "les grenouilles comprennent probablement des secrets anciens.",

  "être vivant est étrange, mais aussi magnifique.",

  "les vieilles bibliothèques ressemblent à des dragons endormis.",

  "parfois, survivre est déjà une forme de courage.",

  "les lucioles sont des étoiles qui ont oublié le ciel.",

  "certaines nuits semblent irréelles.",

  "les humains sont faits de souvenirs temporaires.",

  "la nostalgie internet est une vraie émotion."

];

const quoteElement =
  document.getElementById("dailyQuote");

const randomQuote =

  quotes[
    Math.floor(Math.random() * quotes.length)
  ];

let index = 0;

function typeQuote() {

  if (index < randomQuote.length) {

    quoteElement.textContent +=
      randomQuote.charAt(index);

    index++;

    setTimeout(typeQuote, 45);

  }

}

quoteElement.textContent = "";

typeQuote();