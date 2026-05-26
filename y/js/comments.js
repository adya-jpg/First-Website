
import { initializeApp }
from "https://www.gstatic.com/firebasejs/10.12.2/firebase-app.js";

import {
  getFirestore,
  collection,
  addDoc,
  query,
  orderBy,
  onSnapshot,
  serverTimestamp,
  deleteDoc,
  doc,
  updateDoc
}
from "https://www.gstatic.com/firebasejs/10.12.2/firebase-firestore.js";

const firebaseConfig = {
  apiKey: "AIzaSyDSXS0qoVc7OBTtUlaN9RNM4bSHvMedAvM",
  authDomain: "leblogd-adya.firebaseapp.com",
  projectId: "leblogd-adya",
  storageBucket: "leblogd-adya.firebasestorage.app",
  messagingSenderId: "135127492871",
  appId: "1:135127492871:web:dd039554a5f4e3e8467da2",
  measurementId: "G-K2YPSE27VG"
};

let userId = localStorage.getItem("userId");

if (!userId) {

  userId = crypto.randomUUID();

  localStorage.setItem("userId", userId);

}

const app = initializeApp(firebaseConfig);

const db = getFirestore(app);


const pageId = document.body.dataset.page;
const commentsRef = collection(db, `comments_${pageId}`);

const q = query(commentsRef, orderBy("time"));


onSnapshot(q, (snapshot) => {

  const commentsDiv =
    document.getElementById("comments");

  commentsDiv.innerHTML = "";

  snapshot.forEach((commentDoc) => {

    const data = commentDoc.data();

    const div =
      document.createElement("div");

    div.className = "comment";

    div.innerHTML = `
      <strong>${data.name}</strong><br>

      <p>${data.message}</p>

      ${
        data.ownerId === userId
          ? `
            <button class="delete-btn">
              supprimer
            </button>

            <button class="edit-btn">
              modifier
            </button>
          `
          : ""
      }
    `;

    commentsDiv.appendChild(div);

    const deleteBtn =
      div.querySelector(".delete-btn");

    if (deleteBtn) {

      deleteBtn.addEventListener("click", async () => {

        await deleteDoc(
          doc(db, `comments_${pageId}`, commentDoc.id)
        );

      });

    }

    const editBtn =
      div.querySelector(".edit-btn");

    if (editBtn) {

      editBtn.addEventListener("click", async () => {

        const newMessage = prompt(
          "modifier le commentaire :",
          data.message
        );

        if (!newMessage) return;

        await updateDoc(
          doc(db, `comments_${pageId}`, commentDoc.id),
          {
            message: newMessage
          }
        );

      });

    }

  });

});

document
.getElementById("envoyer")
.addEventListener("click", async () => {

  const name =
    document.getElementById("nom").value.trim();

  const message =
    document.getElementById("message").value.trim();

  if (!name || !message) return;

   await addDoc(commentsRef, {

    name,
    message,

    ownerId: userId,

    time: serverTimestamp()

  });

  document.getElementById("nom").value = "";

  document.getElementById("message").value = "";

});

