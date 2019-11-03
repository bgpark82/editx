class AuthService {
  login(username) {
    sessionStorage.setItem("authentication", username);
  }

  logout() {
    sessionStorage.removeItem("authentication");
  }
}

export default new AuthService();
