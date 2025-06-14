import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Concepts from './components/Concepts'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <Concepts />
      </div>
    </>
  )
}

export default App
