import './custom-button.style.css'

export function CustomButton({ onClick, textArea }) {

    return (
        <button onClick={onClick} className="custom-button">{textArea}</button>
    )
}
