class AuthService {
  login(username) {
    sessionStorage.setItem("authentication", username);
  }
}

export default new AuthService();
