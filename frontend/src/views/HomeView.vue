<template>
  <div class="header">
    <div class="lab-name">🚁 CIDER 연구실</div>

    <div class="user-actions">
      <template v-if="username">
        <span class="welcome-msg">{{ username }}님 환영합니다!</span>
        <button class="logout-btn" @click="logout">로그아웃</button>
      </template>
      <template v-else>
        <router-link to="/login">로그인</router-link>
      </template>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  data() {
    return {
      username: localStorage.getItem('username')
    };
  },
  methods: {
    logout() {
      localStorage.removeItem('username');
      this.username = null;  // 수동으로 반응형 업데이트
    }
  }
}
</script>

<style scoped>
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1.5rem 2rem;
  background-color: #f8f8f8;
  border-bottom: 1px solid #ddd;
}

.lab-name {
  font-size: 1.8rem;
  font-weight: bold;
  text-align: center;
  flex: 1;
}

.user-actions {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.welcome-msg {
  font-weight: bold;
  font-size: 1rem;
}

.logout-btn {
  background-color: transparent;
  color: #42b983;
  border: 1px solid #42b983;
  padding: 0.5rem 1rem;
  border-radius: 6px;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s;
}

.logout-btn:hover {
  background-color: #42b983;
  color: white;
}

.user-actions a {
  text-decoration: none;
  color: #42b983;
  font-weight: bold;
  padding: 0.5rem 1rem;
  border: 1px solid #42b983;
  border-radius: 6px;
  transition: background-color 0.3s, color 0.3s;
}

.user-actions a:hover {
  background-color: #42b983;
  color: white;
}
</style>
