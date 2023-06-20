package com.maro.maro_openai_client.openai.datum.requests.chat

data class ChatRequest(
    val model: String = "gpt-3.5-turbo",
    val messages: List<Message>,
    //사용할 샘플링 온도는 0과 2 사이입니다. 0.8과 같은 값이 클수록 출력은 더 랜덤하게 되고 0.2와 같은 값이 낮을수록 더 집중적이고 결정론적으로 됩니다.
    //일반적으로 이 또는 top_p를 변경하는 것이 좋지만 둘 다 변경하는 것은 권장하지 않습니다.
    val temperature: Double? = 1.toDouble(),
    //모델이 top_p 확률 질량을 갖는 토큰의 결과를 고려하는 핵 샘플링이라고 하는 온도 샘플링의 대안입니다. 따라서 0.1은 상위 10% 확률 질량을 구성하는 토큰만 고려된다는 의미입니다.
    //일반적으로 이 값이나 온도를 변경하는 것이 좋지만 둘 다 변경하는 것은 권장하지 않습니다.
    val top_p: Double? = 1.toDouble(),
)

