window.toggleSound = function(soundId) {

  const sounds = document.querySelectorAll("audio");

  sounds.forEach(sound => {

    if (sound.id !== soundId) {
      sound.pause();
      sound.currentTime = 0;
    }

  });

  const selected =
    document.getElementById(soundId);

  if (selected.paused) {

    selected.play();

  } else {

    selected.pause();

  }

};