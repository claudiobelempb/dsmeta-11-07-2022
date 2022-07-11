import brand from '../../assets/images/brand.svg';
import './styles.css';

const Header: React.FC = () => {
  return (
    <header>
      <div className='dsmeta-logo-container'>
        <img src={brand} alt='DSMeta' />
        <h1>DSMeta</h1>
        <p>
          Desenvolvido por
          <a href='https://www.instagram.com/devsuperior.ig'>@devsuperior.ig</a>
        </p>
      </div>
    </header>
  );
};

export { Header };
