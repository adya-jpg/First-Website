

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

