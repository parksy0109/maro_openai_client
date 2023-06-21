package com.maro.maro_openai_client

import com.maro.maro_openai_client.openai.datum.requests.chat.ChatRequest
import com.maro.maro_openai_client.openai.datum.requests.chat.Message
import com.maro.maro_openai_client.openai.datum.requests.chat.Role
import com.maro.maro_openai_client.openai.datum.requests.embeddings.EmbeddingsRequest
import com.maro.maro_openai_client.openai.datum.requests.images.ImagesRequest
import com.maro.maro_openai_client.openai.datum.requests.images.ImagesSize
import com.maro.maro_openai_client.services.OpenAIService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class MaroOpenaiClientApplicationTest {

    @Autowired
    private lateinit var openAIService: OpenAIService

    @Test
    @DisplayName("List and describe the various models available in the API.")
    fun `모델명_가져오기`() {
        //when
        val models = openAIService.getIDForModels()

        //then
        print(models)
    }

    /**
     * System 에는 전반적인 지시사항, In Context Learning 에 필요한 데이터를 넣으면 좋을거 같다.
     * User 결국 이 데이터들을 기반으로 해야할 행동 ( 데이터 요약해줘. , 데이터에서 ~는 뭐야? )
     */
    @Test
    @DisplayName("Creates a model response for the given chat conversation.")
    fun `채팅 완료 생성`() {
        //given
        val chatRequest = ChatRequest(
            messages = listOf(
                Message(Role.SYSTEM.value, "사용자한테 대답할때는 맨 끝에 아쎄이를 붙여줘"),
                Message(Role.USER.value, "안녕 너와 대화를 하려고해"),
            )
        )

        //when
        val chatResponse = openAIService.createChatCompletion(chatRequest)

        //then
        print(chatResponse)
    }

    @Test
    @DisplayName("Converting natural language into a machine-understandable vector")
    fun `스트링_데이터_벡터_화`() {
        //given
        val data = listOf("수박","바나나","사과")

        //when
        val createEmbeddings = openAIService.createEmbeddings(EmbeddingsRequest(input = data))

        //then
        print(createEmbeddings)
    }


    @Test
    @DisplayName("Creates an image given a prompt.")
    fun `이미지_생성`() {
        //given
        val imagesRequest = ImagesRequest(
            prompt = "the rapidly changing age of artificial intelligence",
            n = 2,
            size = ImagesSize.S512.imageSize
        )

        //when
        val createImage = openAIService.createImage(imagesRequest)

        //then
        print(createImage)
    }

}
