
const frog = document.getElementById("frog");

const frogText =
  document.getElementById("frogText");

const frogMessages = [

  "la pluie est jolie ce soir.",

  "hydrate-toi s'il te plaît.",

  "tu codes encore à minuit ?",

  "les forêts cachent des secrets.",

  "ce site devient dangereux.",

  "tu devrais probablement dormir.",

  "les étoiles te regardent.",

  "le thé refroidit encore.",

  "les grenouilles soutiennent ton blogue.",

  "la nostalgie internet est éternelle.",

  "↑ ↑ ↓ ↓ ... les grenouilles murmurent quelque chose.",

    "← → ← → ... étrange.",

    "les anciens visiteurs connaissaient un code.",

    "b... a... ?",

    "le bassin répond aux séquences.",

    "essaie les flèches. toutes.",

    "certains secrets nécessitent dix touches.",

    "la forêt aime les tricheurs.",

    "tu es plus proche du secret que tu le crois.",

    "le protocole konami existe encore.",
  

];

frog.addEventListener("click", () => {

  const randomMessage =

    frogMessages[
      Math.floor(
        Math.random() * frogMessages.length
      )
    ];

  frogText.innerText = randomMessage;

});

