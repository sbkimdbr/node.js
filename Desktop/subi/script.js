const socket = io('http://localhost:5000')
const messageContainer = document.getElementById('message-container')
const messageForm=document.getElementById('send-container')
const messageInput = document.getElementById('message-input')

const name = prompt('what is your name?')
appendMessage('you joined')
socket.emit('new-user',name)

socket.on('chat-message',data=> {
        // console.log(data)
        appendMessage(`${data.name}:${data.message}`)
    })

socket.on('user-connected', name=>{
    // console.log(data)
    appendMessage(`${name} connected`)
})

socket.on('user-disconnected', name=>{
    // console.log(data)
    appendMessage(`${name} disconnected`)
})

messageForm.addEventListener('submit',e=>{
    e.preventDefault()

    const message = messageInput.value
    appendMessage(`You: ${message}`)
    socket.emit('send-chat-message',message)//이름이 모두 You로 변경되서 보내짐 
    messageInput.value=''

})

function appendMessage(message){
    const messageElement=document.createElement('div')
    messageElement.innerText=message
    messageContainer.append(messageElement)
}