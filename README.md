## Kotlin API Call

Kotlinプロジェクトで使用。(Spring boot等)
外部のAPIをCallするクラス。

## Jacksonのimport
以下をbuildファイルに追加。(Gradleの場合、build.gradle)
callしたJsonレスポンスをオブジェクトクラスにマッピングする際に使用。

```
/* jackson */
implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.0")
```

## オブジェクトクラス
Jacksonを使用してJsonレスポンスをオブジェクトクラスにマッピング。
オブジェクトクラスは以下のように作成。

```
/**
 * JsonObjectMapper クラス.
 */
class SampleDto (
   @JsonProperty("historyId")
   val historyId: Int,
 
   @JsonProperty("taskName")
   val taskName: String,
 
   @JsonProperty("status")
   val status: LmdChangeStatus,
 
   @JsonProperty("dirPath")
   val dirPath: String,
 
   @JsonProperty("createDate")
   val createDate: Date?,
 
   @JsonProperty("updateDate")
   val updateDate: Date?
)
```
