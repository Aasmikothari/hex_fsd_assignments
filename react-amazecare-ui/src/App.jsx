import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Concepts from './components/Concepts'
import Post from './components/Post'
import AddPost from './components/AddPost'
import FetchPost from './components/FetchPost'
import Login from './components/Login'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <Login />
      </div>
    </>
  )
}

export default App
