## Kotlin API Call

外部のAPIをCallするクラス。

## Jacksonのimport
以下をbuildファイルに追加。(Gradleの場合、build.gradle)
callしたレスポンスをオブジェクト変換する際に使用。

`/* jackson */
     implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.0")`

## オブジェクトクラス
Jacksonを使用してJsonレスポンスをオブジェクトクラスに変換。
オブジェクトクラスは以下のように作成。

`
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
 `
