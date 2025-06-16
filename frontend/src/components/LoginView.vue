<template>
  <div class="login-container">
    <h2>🔐 로그인</h2>

    <div class="form-group">
      <label for="username">아이디</label>
      <input type="text" id="username" v-model="username" />
    </div>

    <div class="form-group">
      <label for="password">비밀번호</label>
      <input type="password" id="password" v-model="password" />
      <div class="signup-link">
        <router-link to="/signup">회원가입</router-link>
      </div>
    </div>

    <button class="login-btn" @click="login">로그인</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'LoginView',
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    async login() {
      try {
        const response = await axios.post('/api/login', {
          username: this.username,
          password: this.password
        });

        console.log('서버 응답:', response.data);
        alert('로그인 성공!');
        localStorage.setItem('username', this.username);

        // 예: 다음 페이지로 이동
        this.$router.push('/'); // '/main' 대신 원하는 경로

      } catch (error) {
        console.error('로그인 오류:', error);
        alert('로그인 실패: 아이디 또는 비밀번호를 확인하세요.');
      }
    }
  }
}
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: 80px auto;
  padding: 2rem;
  border: 1px solid #ccc;
  border-radius: 12px;
  background-color: #fafafa;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
  font-family: 'Segoe UI', sans-serif;
}

h2 {
  text-align: center;
  margin-bottom: 2rem;
}

.form-group {
  margin-bottom: 1.5rem;
  position: relative;
}

label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: bold;
}

input {
  width: 100%;
  padding: 0.6rem;
  border: 1px solid #ddd;
  border-radius: 6px;
}

.login-btn {
  width: 100%;
  padding: 0.8rem;
  background-color: #42b983;
  color: white;
  font-weight: bold;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.login-btn:hover {
  background-color: #369f6e;
}

.signup-link {
  position: absolute;
  right: 0;
  bottom: -5.5rem;
  font-size: 0.9rem;
}

.signup-link a {
  color: #42b983;
  text-decoration: none;
}

.signup-link a:hover {
  text-decoration: underline;
}
</style>
