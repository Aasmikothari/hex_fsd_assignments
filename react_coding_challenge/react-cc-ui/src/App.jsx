import React from 'react';
import { Routes, Route, NavLink } from 'react-router-dom';
import UserList from './components/UserList';
import AddUser from './components/AddUser';
import EditUser from './components/EditUser';

function App() {
  return (
    <div>
      <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-3">
          <NavLink className="navbar-brand" to="/">User Management Dashboard</NavLink>
          <div className="navbar-nav">
            <NavLink className="nav-link" to="/users">User List</NavLink>
            <NavLink className="nav-link" to="/add-user">Add User</NavLink>
          </div>
        </nav>

        <div className="container mt-4"> 
          <Routes>
            <Route path="/users" element={<UserList />} />
            <Route path="/add-user" element={<AddUser />} />
            <Route path="/edit-user/:id" element={<EditUser />} />
            <Route path="*" element={<UserList />} />
          </Routes>
        </div>
      </div>
    </div>
  );
}

export default App