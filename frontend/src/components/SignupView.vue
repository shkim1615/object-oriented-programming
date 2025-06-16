<template>
  <div class="signup-container">
    <h2>📝 회원가입</h2>

    <div class="form-group" v-for="field in fields" :key="field.key">
      <label :for="field.key">{{ field.label }}</label>
      <input
        :id="field.key"
        v-model="form[field.key]"
        :type="field.type"
        :placeholder="field.label + '을 입력하세요'"
      />
    </div>

    <button class="signup-btn" @click="submitSignup">회원가입 신청</button>

    <p v-if="submitted" class="success-msg">✅ 회원가입 신청이 완료되었습니다. 관리자의 승인을 기다려주세요!</p>
  </div>
</template>

<script>
export default {
  name: 'SignupView',
  data() {
    return {
      form: {
        username: '',
        password: '',
        name: '',
        studentId: '',
        email: ''
      },
      submitted: false,
      fields: [
        { key: 'username', label: '아이디', type: 'text' },
        { key: 'password', label: '비밀번호', type: 'password' },
        { key: 'name', label: '이름', type: 'text' },
        //{ key: 'studentId', label: '학번', type: 'text' },
        { key: 'email', label: '이메일', type: 'email' }
      ]
    };
  },
  methods: {
    submitSignup() {
      // 나중에 서버로 form 전송 추가 예정!
      console.log('회원가입 정보:', this.form);
      this.submitted = true;
    }
  }
}
</script>

<style scoped>
.signup-container {
  max-width: 450px;
  margin: 80px auto;
  padding: 2rem;
  border: 1px solid #ccc;
  border-radius: 12px;
  background-color: #fdfdfd;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
  font-family: 'Segoe UI', sans-serif;
}

h2 {
  text-align: center;
  margin-bottom: 2rem;
}

.form-group {
  margin-bottom: 1.2rem;
}

label {
  display: block;
  margin-bottom: 0.4rem;
  font-weight: bold;
}

input {
  width: 100%;
  padding: 0.6rem;
  border: 1px solid #ddd;
  border-radius: 6px;
}

.signup-btn {
  width: 100%;
  padding: 0.8rem;
  background-color: #42b983;
  color: white;
  font-weight: bold;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s;
  margin-top: 1rem;
}

.signup-btn:hover {
  background-color: #369f6e;
}

.success-msg {
  margin-top: 1.5rem;
  text-align: center;
  color: #2e7d32;
  font-weight: bold;
}
</style>
