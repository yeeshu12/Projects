function toggleMenu() {
  const nav = document.getElementById('navLinks');
  nav.style.display = nav.style.display === 'flex' ? 'none' : 'flex';
}

function scrollToSection(id) {
  document.getElementById(id).scrollIntoView({ behavior: 'smooth' });
}

function showAlert() {
  alert('Message sent successfully');
  return false;
}
