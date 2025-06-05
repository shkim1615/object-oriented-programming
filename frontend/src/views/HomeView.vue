<template>
  <div class="home">
    <!-- 상단 인삿말 배너 -->
    <section class="hero">
      <h1>🚁 CIDER 연구실 드론 데이터 시스템</h1>
      <p>비행 데이터를 안전하게 저장하고, 분석해 연구에 활용하세요.</p>
    </section>

    <!-- 기능 소개 -->
    <section class="features">
      <div class="feature">
        <h2>📦 데이터 업로드</h2>
        <p>CSV, 로그 파일을 업로드하여 서버에 저장합니다.</p>
      </div>
      <div class="feature">
        <h2>📊 시각화</h2>
        <p>비행 경로, 센서 데이터 등을 그래프로 분석합니다.</p>
      </div>
    </section>

    <!-- 버튼 -->
    <section class="cta">
      <router-link to="/dashboard" class="btn">📈 대시보드로 이동</router-link>
    </section>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
}
</script>

<style scoped>
.home {
  text-align: center;
  padding: 2rem;
  font-family: 'Segoe UI', sans-serif;
}

.hero {
  background-color: #e8f5e9;
  padding: 2rem;
  border-radius: 12px;
  margin-bottom: 2rem;
}

.features {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
  gap: 1.5rem;
  margin-bottom: 2rem;
}

.feature {
  background: #f4f4f4;
  border-radius: 10px;
  padding: 1rem;
  flex: 1 1 250px;
  box-shadow: 0 2px 6px rgba(0,0,0,0.1);
}

.cta .btn {
  background-color: #42b983;
  color: white;
  padding: 1rem 2rem;
  font-weight: bold;
  text-decoration: none;
  border-radius: 8px;
  display: inline-block;
  transition: background-color 0.3s;
}
.cta .btn:hover {
  background-color: #369f6e;
}
</style>
