import { Link, useParams } from "react-router-dom"

const Contact = () => {
    const { name, age } = useParams()
    console.log(name, age)
    return (
        <>
            <nav>
                <ul>
                    <li> <Link to="/">HOME</Link>           </li>
                    <li> <Link to="/about">ABOUT</Link> </li>
                    <li> <Link to="/contact">CONTACT</Link> </li>
                </ul>
            </nav>
            <h1>Contact PAGE</h1>
            <Link to="/">Home</Link>
        </>
    )
}

export default Contact;