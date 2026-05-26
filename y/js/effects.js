
const trailSymbols = ["✦", "⋆", "☾", "❀"];

document.addEventListener("mousemove", (e) => {

  const sparkle = document.createElement("div");

  sparkle.className = "cursor-trail";

  sparkle.innerText =
    trailSymbols[
      Math.floor(Math.random() * trailSymbols.length)
    ];

  sparkle.style.left = e.pageX + "px";
  sparkle.style.top = e.pageY + "px";

  document.body.appendChild(sparkle);

  setTimeout(() => {
    sparkle.remove();
  }, 900);

});

function createLeaf() {

  const leaf = document.createElement("div");

  leaf.classList.add("leaf");

const symbols = document.body.classList.contains("night-mode")
  ? ["✦", "⋆", "☾"]
  : ["🍃", "❀"];

leaf.innerHTML =
  symbols[
    Math.floor(Math.random() * symbols.length)
  ];

  leaf.style.left =
    Math.random() * window.innerWidth + "px";

  leaf.style.animationDuration =
    (6 + Math.random() * 6) + "s";

  leaf.style.opacity =
    0.3 + Math.random() * 0.5;

  leaf.style.fontSize =
    (14 + Math.random() * 18) + "px";

  document.body.appendChild(leaf);

  setTimeout(() => {
    leaf.remove();
  }, 12000);

}

setInterval(createLeaf, 900);



