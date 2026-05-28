
const forestEmails = [

  {
    subject: "vieille nostalgie internet détectée",
    body: `
      <strong>FROM:</strong> foret.systeme<br>
      <strong>TO:</strong> visiteur<br><br>

      Bonsoir.<br><br>

      La forêt numérique semble calme ce soir.<br>
      Les grenouilles dorment près du bassin.<br>
      Les lucioles dérivent encore entre les vieux pixels.<br><br>

      N'oublie pas de boire de l'eau
      et de regarder le ciel parfois.<br><br>

      — adya.exe
    `
  },

  {
    subject: "les lucioles te cherchent",
    body: `
      <strong>FROM:</strong> luciole.sys<br>
      <strong>TO:</strong> lecteur<br><br>

      Certaines lumières n'existent
      que pour guider les voyageurs fatigués.<br><br>

      Peut-être que toi aussi,
      tu brilles un peu dans l'obscurité.<br><br>

      La forêt te remercie de ta visite.
    `
  },

  {
    subject: "message récupéré dans la pluie",
    body: `
      <strong>FROM:</strong> pluie.archive<br>
      <strong>TO:</strong> inconnu<br><br>

      Les vieux sites web ne meurent jamais vraiment.<br>
      Ils deviennent simplement silencieux.<br><br>

      Merci d'avoir réveillé celui-ci.
    `
  }

];

document
  .getElementById("openMail")
  .addEventListener("click", openForestMail);

function openForestMail() {

  const chosenMail =
    forestEmails[
      Math.floor(Math.random() * forestEmails.length)
    ];

  const mailWindow =
    document.createElement("div");

  mailWindow.className = "mail-window";

  mailWindow.innerHTML = `

    <div class="mail-header">

      <span>
        boîte_mail.exe — ${chosenMail.subject}
      </span>

      <span class="mail-close">
        ✕
      </span>

    </div>

    <div class="mail-content">
      ${chosenMail.body}
    </div>

  `;

  document.body.appendChild(mailWindow);

  mailWindow
    .querySelector(".mail-close")
    .addEventListener("click", () => {

      mailWindow.remove();

    });

  makeDraggable(mailWindow);

}

function makeDraggable(windowElement) {

  const header =
    windowElement.querySelector(".mail-header");

  let offsetX = 0;
  let offsetY = 0;
  let isDragging = false;

  header.addEventListener("mousedown", (e) => {

    isDragging = true;

    offsetX =
      e.clientX - windowElement.offsetLeft;

    offsetY =
      e.clientY - windowElement.offsetTop;

  });

  document.addEventListener("mousemove", (e) => {

    if (!isDragging) return;

    windowElement.style.left =
      e.clientX - offsetX + "px";

    windowElement.style.top =
      e.clientY - offsetY + "px";

  });

  document.addEventListener("mouseup", () => {

    isDragging = false;

  });

}