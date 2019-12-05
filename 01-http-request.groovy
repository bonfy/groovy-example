// HTTP Get

def connection = new URL("https://httpbin.org/get").openConnection()
def response_code = connection.getResponseCode()
println(response_code)

if(response_code.equals(200)) {
    def text = connection.getInputStream().getText()
    println(text)
}

// HTTP POST

def conn = new URL("https://httpbin.org/post").openConnection()
def message = '''
{"message": "this is a message"}
'''

conn.setRequestMethod("POST")
conn.setDoOutput(true)
conn.setRequestProperty("Content-Type", "application/json")

conn.getOutputStream().write(message.getBytes("UTF-8"))
def status_code = conn.getResponseCode()
println(status_code)
if(status_code.equals(200)) {
    def text = conn.getInputStream().getText()
    println(text)
}
