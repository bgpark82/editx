class AuthService {
  login(username) {
    sessionStorage.setItem("authentication", username);
  }

  logout() {
    sessionStorage.removeItem("authentication");
  }

  isLoggedIn() {
    return this.getUsername() === null ? false : true;
  }

  getUsername() {
    return sessionStorage.getItem("authentication");
  }
}

export default new AuthService();
