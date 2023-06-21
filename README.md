# maro_openai_client
##Step 1
```terminal
./gradlew build -x test
```

##Step 2
본인 프로젝트 루트 디렉토리에 libs 폴더 생성하고 빌드된 파일을 넣는다.

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
자신 프로젝트에 main 함수 있는 곳에 어노테이션을 달아준다.
```
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = ["your_project_package","com.maro.maro_openai_client"])
class SpringBootApplication

fun main(args: Array<String>) {
  runApplication<SpringBootApplication>(*args)
}
```
