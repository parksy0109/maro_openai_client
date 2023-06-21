# maro_openai_client
##Step 1
```terminal
./gradlew build -x test
```

##Step 2
해당 라이브러리를 사용할 프로젝트 루트 디렉토리에 libs 폴더 생성하고 빌드된 파일을 넣는다.

##Step 3
종속성을 추가한다.
```gradle
dependencies {
  implementation(files("${rootDir}/libs/maro_openai_client-0.0.1-SNAPSHOT-plain.jar"))
  
  implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
	implementation("org.springframework.cloud:spring-cloud-starter-config")
}

dependencyManagement {
	imports {
		mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.4")
	}
}
```

##Step 4
프로젝트에 main 함수 있는 곳에 어노테이션을 달아준다.
```kotlin
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = ["your_project_package","com.maro.maro_openai_client"])
class SpringBootApplication

fun main(args: Array<String>) {
  runApplication<SpringBootApplication>(*args)
}
```

##Step 5
```application.properties
spring.cloud.config.enabled=false

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

openai.api.key=input_your_api_key
```

##기능
OpenAI models, chat, embeddings API
```kotlin
	fun `모델명_가져오기`() {
        	val models = openAIService.getIDForModels()
    	}
```

```kotlin
	fun `채팅 완료 생성`() {
        val chatRequest = ChatRequest(
            messages = listOf(
                Message(Role.SYSTEM.value, "사용자한테 대답할때는 맨 끝에 아쎄이를 붙여줘"),
                Message(Role.USER.value, "안녕 너와 대화를 하려고해"),
            )
        )

        val chatResponse = openAIService.createChatCompletion(chatRequest)
    }
```

```kotlin
	fun `스트링_데이터_벡터_화`() {
        val data = listOf("수박","바나나","사과")

        val embeddings = openAIService.createEmbeddings(EmbeddingsRequest(input = data))
    }
```
